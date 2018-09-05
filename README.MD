Example - calling MAS Client REST api  to generate interestRate/finanical reports
================================

The article: []  

-----------
[Requirements]
------------
* [Java Platform (JDK) 8](http://www.oracle.com/technetwork/java/javase/downloads/index.html)  
* [Apache Maven 3.x](http://maven.apache.org/)

-----------
[Quick start]
-----------
1. `mvn install`
2.  to run 		-->		`java -jar target/MASApi-1.0-SNAPSHOT.jar report.type=M start.date=Jan-2018 end.date=Aug-2018 display.type=1,3-4,9`  
3.  to export the report to a file, you may use append mode '> masreport.log', `java -jar target/MASApi-1.0-SNAPSHOT.jar report.type=M start.date=Jan-2018 end.date=Aug-2018 display.type=1,3-4,9 > masreport.log`
4.  to display the report file, window dos -> `type masreport.log`   , linux -> `cat masreport.log`  
5.  arguments input eg.  
	i)		report.type=M [M=monthly, m=monthly, Y=yearly, y=yearly]  
	iI)		start.date=Jan-2018 [MMM-yyyy]  
	iii)	end.date=Aug-2018 [MMM-yyyy]  
	iv)		isplay.type=1,3-4,9 [1-11 only, support range input '-' with comma separator ]  
	
	
-----------
[Assumption]
-----------
1. RESOURCE_ID = `5f2b18a8-0883-4769-a635-879c63d3caac` for monthly, `bd841397-108f-4644-8da3-38a7c159d68a` for yearly  
2. Only support 2 report types, the report will go by asscending order, when the trend is up it will have a '+' beside the percenage and '-' if it is going down from previous month/year rates.  
3. ReportGenerator is a interface class and can be used to impelment different reports type, passing the data objects (InterestRate->Result->Records)  
4. Processor is a interface calss and can be used to implement the two different report processing (business logic) type (monthly, yearly),   
5. ProcessorImpl is a abstract class to force the implementation of `process` method and the variables object by its inheritance class, it also encapsulate `generateReport` method and variables  
5. enum object is used and that is mapped to the Spring configuration beans for the impelmention ProcessorImpl class.  
6. the program does not use Database or Filesystem to store data, if required DAO (Data Access Object) can be used  
7. there is no properties variables used, the varibles are in constants class, if required, it can be changed to load from properties using Spring Configuration.  


-----------
[MANIFEST]
-----------
META-INF/  
META-INF/MANIFEST.MF  
com/  
com/ks/  
com/ks/masapi/  
com/ks/masapi/connector/  
com/ks/masapi/constants/  
com/ks/masapi/exception/  
com/ks/masapi/model/  
com/ks/masapi/model/option/  
com/ks/masapi/processor/  
com/ks/masapi/processor/impl/  
com/ks/masapi/report/  
com/ks/masapi/report/impl/  
com/ks/masapi/util/  
com/ks/masapi/connector/RestClientConnector.class  
com/ks/masapi/constants/AppConstants$RecordTypeEnum.class  
com/ks/masapi/constants/AppConstants$ReportTypeEnum.class  
com/ks/masapi/constants/AppConstants.class  
com/ks/masapi/exception/AppException.class  
com/ks/masapi/MainClass.class  
com/ks/masapi/model/InterestRate.class  
com/ks/masapi/model/option/ArgumentOption.class  
com/ks/masapi/model/option/RecordTypeOption.class  
com/ks/masapi/model/Record.class  
com/ks/masapi/model/Result.class  
com/ks/masapi/processor/impl/ProcessorImpl.class  
com/ks/masapi/processor/impl/ProcessorMonthlyImpl.class  
com/ks/masapi/processor/impl/ProcessorYearlyImpl.class  
com/ks/masapi/processor/Processor.class  
com/ks/masapi/report/impl/ReportMonthly$1.class  
com/ks/masapi/report/impl/ReportMonthly.class  
com/ks/masapi/report/impl/ReportYearly$1.class  
com/ks/masapi/report/impl/ReportYearly.class  
com/ks/masapi/report/ReportGenerator.class  
com/ks/masapi/util/JsonHelper.class  
log4j.properties  
MASApi-context.xml  
META-INF/maven/  
META-INF/maven/com.ks/  
META-INF/maven/com.ks/MASApi/  
META-INF/maven/com.ks/MASApi/pom.xml  
META-INF/maven/com.ks/MASApi/pom.properties  
  
-----------
[SAMPLE OUTPUT]
-----------
example of reports in JUnit  
 Monthly report datetime  ---    2018-09-04 21:54:09  
  
 Year|Month|       prime_lending_rate|  banks_fixed_deposits_6m|     fc_fixed_deposits_6m  
 2018|   01|                     5.33|                     0.22|                     0.38  
 2018|   02|                     5.33|                     0.22|                     0.38  
 2018|   03|                     5.33|                     0.22|                     0.38  
 2018|   04|                     5.33|                     0.22|                     0.38  
 2018|   05|                     5.33|                     0.22|                     0.38  
 2018|   06|                     5.33|                     0.22|                     0.38  
 2018|   07|                     5.33|                  +  0.23|                     0.38  
 2018|   08|                     5.33|                     0.23|                  -  0.00  
  
 Monthly report datetime  ---    2018-09-04 21:54:10  
  
 Year|Month|  banks_fixed_deposits_3m|  banks_fixed_deposits_6m| banks_fixed_deposits_12m|fc_hire_purchase_motor_3y|     fc_housing_loans_15y|     fc_fixed_deposits_3m  
 2017|   01|                     0.15|                     0.20|                     0.33|                     4.97|                     3.41|                     0.30  
 2017|   02|                     0.15|                     0.20|                     0.33|                  +  5.26|                     3.41|                     0.30  
 2017|   03|                  -  0.14|                     0.20|                     0.33|                     5.26|                  -  3.16|                     0.30  
 2017|   04|                     0.14|                     0.20|                     0.33|                     5.26|                     3.16|                     0.30  
 2017|   05|                     0.14|                     0.20|                     0.33|                     5.26|                     3.16|                     0.30  
 2017|   06|                     0.14|                     0.20|                     0.33|                     5.26|                     3.16|                     0.30  
 2017|   07|                     0.14|                     0.20|                     0.33|                     5.26|                     3.16|                     0.30  
 2017|   08|                     0.14|                     0.20|                     0.33|                     5.26|                     3.16|                     0.30  
 2017|   09|                     0.14|                     0.20|                     0.33|                     5.26|                     3.16|                     0.30  
  
 Yearly report datetime   ---    2018-09-04 21:54:11  
  
 Year|   banks_savings_deposits|      fc_savings_deposits  
 2001|                     0.77|                     0.85  
 2002|                  -  0.44|                  -  0.55  
 2003|                  -  0.24|                  -  0.31  
 2004|                  -  0.23|                     0.31  
 2005|                  +  0.26|                  +  0.42  
 2006|                  -  0.25|                  -  0.33  
 2007|                     0.25|                     0.33  
 2008|                  -  0.22|                  -  0.25  
 2009|                  -  0.15|                     0.25  
 2010|                  -  0.13|                     0.25  
 2011|                  -  0.11|                  -  0.17  
 2012|                     0.11|                     0.17  
 2013|                  -  0.10|                     0.17  
 2014|                  +  0.11|                     0.17  
 2015|                  +  0.14|                     0.17  
 2016|                     0.14|                     0.17  
 2017|                  +  0.16|                     0.17  
  
 Yearly report datetime   ---    2018-09-04 21:54:13  
  
 Year|       prime_lending_rate|  banks_fixed_deposits_6m|     fc_fixed_deposits_6m  
 2001|                     5.30|                     1.33|                     1.39  
 2002|                  +  5.35|                  -  1.05|                  -  1.08  
 2003|                  -  5.30|                  -  0.52|                  -  0.60  
 2004|                     5.30|                     0.52|                  +  0.70  
 2005|                     5.30|                  +  0.66|                  +  1.06  
  
 Yearly report datetime   ---    2018-09-04 21:54:14  
  
 Year|  banks_fixed_deposits_3m|  banks_fixed_deposits_6m| banks_fixed_deposits_12m|fc_hire_purchase_motor_3y|     fc_housing_loans_15y|     fc_fixed_deposits_3m  
 1991|                     3.84|                     4.13|                     4.17|                     8.54|                     7.36|                     4.33  
 1992|                  -  2.46|                  -  2.69|                  -  2.97|                  -  7.80|                  -  6.64|                  -  2.55  
 1993|                  -  2.26|                  -  2.51|                  -  2.79|                  -  7.17|                  -  6.48|                  -  2.54  
 1994|                  +  3.62|                  +  3.89|                  +  4.23|                  +  7.51|                  +  7.05|                  +  3.85  
 1995|                  -  3.41|                  -  3.67|                  -  4.01|                  -  6.37|                  -  6.95|                  -  3.18  
 1996|                     3.41|                     3.67|                  -  3.99|                  -  5.71|                  -  6.81|                  +  3.20  
 1997|                  +  4.10|                  +  4.20|                  +  4.41|                  +  7.95|                  +  7.17|                  +  4.00  
 1998|                  -  1.72|                  -  2.08|                  -  2.51|                  -  6.99|                  +  7.31|                  -  1.85  
 1999|                  -  1.68|                  -  2.04|                  -  2.46|                  -  5.41|                  -  6.15|                  -  1.80  
 2000|                  +  1.70|                     2.04|                  -  2.42|                  -  5.19|                     6.15|                     1.80  
 2001|                  -  1.02|                  -  1.33|                  -  1.53|                  +  5.85|                  +  6.40|                  -  1.20  
 2002|                  -  0.78|                  -  1.05|                  -  1.32|                  -  5.15|                  -  6.09|                  -  0.76  
 2003|                  -  0.40|                  -  0.52|                  -  0.70|                  -  4.36|                  -  5.98|                  -  0.44  
 2004|                  +  0.41|                     0.52|                  +  0.72|                  -  4.24|                  -  5.40|                  +  0.48  
 2005|                  +  0.56|                  +  0.66|                  +  0.86|                  +  4.96|                  +  5.56|                  +  0.83  
 2006|                  +  0.57|                  +  0.67|                  +  0.88|                  +  5.65|                  +  5.73|                  +  1.00  
 2007|                  -  0.51|                  -  0.62|                  -  0.83|                     5.65|                     5.73|                  -  0.70  
 2008|                  -  0.39|                  -  0.51|                  -  0.70|                  -  5.42|                  -  5.56|                  -  0.46  
 2009|                  -  0.25|                  -  0.34|                  -  0.53|                  -  4.87|                     5.56|                  -  0.25  
 2010|                  -  0.19|                  -  0.28|                  -  0.45|                  -  3.64|                  -  4.41|                  -  0.19  
 2011|                  -  0.14|                  -  0.19|                  -  0.32|                  -  3.44|                  -  4.26|                  -  0.15  
 2012|                     0.14|                  +  0.20|                     0.32|                     3.44|                  -  2.87|                  +  0.20  
 2013|                     0.14|                     0.20|                     0.32|                  +  4.12|                  +  2.93|                  -  0.18  
 2014|                     0.14|                  +  0.21|                  -  0.31|                     4.12|                     2.93|                     0.18  
 2015|                  +  0.18|                  +  0.24|                  +  0.34|                  +  4.92|                  +  3.22|                  +  0.30  
 2016|                  +  0.19|                  +  0.25|                  +  0.35|                  +  4.97|                  +  3.41|                     0.30  
 2017|                  -  0.14|                  -  0.20|                  -  0.33|                  +  5.06|                  -  3.16|                     0.30  
  
 Yearly report datetime   ---    2018-09-04 21:54:15  
  
 Year|   banks_savings_deposits|      fc_savings_deposits  
 2001|                     0.77|                     0.85  
 2002|                  -  0.44|                  -  0.55  
 2003|                  -  0.24|                  -  0.31  
 2004|                  -  0.23|                     0.31  
 2005|                  +  0.26|                  +  0.42  
 2006|                  -  0.25|                  -  0.33  
 2007|                     0.25|                     0.33  
 2008|                  -  0.22|                  -  0.25  
 2009|                  -  0.15|                     0.25  
 2010|                  -  0.13|                     0.25  
 2011|                  -  0.11|                  -  0.17  
 2012|                     0.11|                     0.17  
 2013|                  -  0.10|                     0.17  
 2014|                  +  0.11|                     0.17  
 2015|                  +  0.14|                     0.17  
 2016|                     0.14|                     0.17  
 2017|                  +  0.16|                     0.17  
   
-----------  
[display.type list]  
-----------  
1	prime_lending_rate					Prime Lending Rate  
2	banks_fixed_deposits_3m	Banks 		Fixed Deposits 3 Months  
3	banks_fixed_deposits_6m	Banks 		Fixed Deposits 6 Months  
4	banks_fixed_deposits_12m			Banks Fixed Deposits 12 Months  
5	banks_savings_deposits				Banks Savings Deposits  
6	fc_hire_purchase_motor_3y			Finance Companies Loans - Hire Purchase of New Vehicles For 3 Years  
7	fc_housing_loans_15y				Finance Companies Housing Loans For 15 Years  
8	fc_fixed_deposits_3m				Finance Companies Fixed Deposits 3 Months  
9	fc_fixed_deposits_6m				Finance Companies Fixed Deposits 6 Months  
10	fc_fixed_deposits_12m				Finance Companies Fixed Deposits 12 Months  
11	fc_savings_deposits					Finance Companies Savings Deposits  

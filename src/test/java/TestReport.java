import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
/** Courtesy of Ashley**/
public class TestReport {

    private ExtentReports report;
    private ExtentTest test;
    private ExtentTest test2;
    private String reportFilePath = "report.html";

    @BeforeClass
    public static void init(){

    }

    @Before
    public void setUp(){
        report = new ExtentReports();
        ExtentHtmlReporter extentHtmlReporter = new ExtentHtmlReporter(reportFilePath);
        extentHtmlReporter.config().setReportName("ReportName");
        extentHtmlReporter.config().setDocumentTitle("DocumentTitle");
        report.attachReporter(extentHtmlReporter);
        test = report.createTest("Login Test");
        test2 = report.createTest("See if Works");
    }

    @Test
    public void myTestMethod(){
        test.log(Status.INFO,"Info level");
        test.fail("Failed");
    }

    public ExtentReports getReport() {

        return report;
    }

    public ExtentTest getExtentTest() {

        return test;
    }

    public ExtentTest getExtentTest2() {

        return test2;
    }



}

package se.uu.medsci.queue.setup

import org.testng.annotations._
import org.testng.Assert
import java.io.File
import se.uu.medsci.queue.SnpSeqBaseTest

class IlluminaXMLReportReaderSnpSeqUnitTest {
       
    /*
     * Note the these tests are dependent on the report.xml file, so if that is changed the tests need to be updated.
     */
    val baseTest = new SnpSeqBaseTest()
    val reportFile: File = new File(baseTest.pathToReportXML)
    val illuminaXMLReportReader = new IlluminaXMLReportReader(reportFile)
    val sampleName = "1"        
    
    
    @Test
    def testGetReadLibrary() {        
        val expected: String = "CEP_C13-NA11992"
        val actual: String = illuminaXMLReportReader.getReadLibrary(sampleName)
    	assert(actual.equals(expected))
    }
    
    @Test
    def testGetFlowcellId() {    	
    	val expected: String = "C0HNDACXX"
        val actual: String = illuminaXMLReportReader.getFlowcellId()
    	assert(actual.equals(expected))
    }
    
    @Test
    def testGetPlatformUnitID() {    	
    	val expected: String = "C0HNDACXX.4"
        val actual: String = illuminaXMLReportReader.getPlatformUnitID(sampleName)        
    	assert(actual.equals(expected))
    }
    
    @Test
    def testGetReadGroupID() {
    	val expected: String = "C0HNDACXX." + sampleName
        val actual: String = illuminaXMLReportReader.getReadGroupID(sampleName)
    	assert(actual.equals(expected))
    }
}
package webTTesting;

import org.junit.Test;

import junit.framework.TestCase;

public class UnitWeb extends TestCase {

	
	@Test
	public void homePage() throws Exception {
	    final WebClient webClient = new WebClient();
	    final HtmlPage page = webClient.getPage("http://htmlunit.sourceforge.net");
	    Assert.assertEquals("HtmlUnit - Welcome to HtmlUnit", page.getTitleText());

	    final String pageAsXml = page.asXml();
	    Assert.assertTrue(pageAsXml.contains("<body class=\"composite\">"));

	    final String pageAsText = page.asText();
	    Assert.assertTrue(pageAsText.contains("Support for the HTTP and HTTPS protocols"));

	    webClient.closeAllWindows();
	}
}

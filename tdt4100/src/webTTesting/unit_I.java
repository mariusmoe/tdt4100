package webTTesting;

import junit.framework.Assert;

import org.junit.Test;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlSubmitInput;
import com.gargoylesoftware.htmlunit.html.HtmlTextInput;

public class unit_I {

	
	@SuppressWarnings("deprecation")
	@Test
	public void homePage() throws Exception {
	    final WebClient webClient = new WebClient();
	    final HtmlPage page = webClient.getPage("http://htmlunit.sourceforge.net");
	    Assert.assertEquals("HtmlUnit – Welcome to HtmlUnit", page.getTitleText());

	    final String pageAsXml = page.asXml();
	    Assert.assertTrue(pageAsXml.contains("<body class=\"composite\">"));

	    final String pageAsText = page.asText();
	    Assert.assertTrue(pageAsText.contains("Support for the HTTP and HTTPS protocols"));

	    webClient.closeAllWindows();
	}
	
	
	@Test
	public void submittingForm() throws Exception {
	    try (final WebClient webClient = new WebClient(BrowserVersion.FIREFOX_38)) {

	    	
	        // Get the first page
	        final HtmlPage page1 = webClient.getPage("https://kahoot.it/#/");

	        // Get the form that we are dealing with and within that form, 
	        // find the submit button and the field that we want to change.	ng-pristine ng-valid
	       // final HtmlForm form = page1.getFormByName("myform");
	      //  System.out.println(page1.asText());
	        final HtmlForm form = page1.getFirstByXPath("/");

	        //final HtmlSubmitInput button = form.getInputByName("btn btn-block btn-greyscale join");
	        final HtmlTextInput textField = form.getInputByName("inputSession");

	        // Change the value of the text field
	        textField.setValueAttribute("400981");

	        // Now submit the form by clicking the button and get back the second page.
	        //final HtmlPage page2 = button.click();
	    }
	}
	
}

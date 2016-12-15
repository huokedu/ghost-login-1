package zz.pseas.ghost.login.qq.util;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.logging.LogFactory;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class GetMIMA {
	public static String password(String $hexqq, String $password, String $verify)
			throws FailingHttpStatusCodeException, MalformedURLException, IOException {

		String homeUrl = "file:///D:/work/others/workspace/work02/ghost-login_v1/ghost-login/ghost-login/resources/qq/q.html";

		WebClient client = new WebClient(BrowserVersion.CHROME);
		client.getOptions().setThrowExceptionOnScriptError(false);
		client.getOptions().setUseInsecureSSL(true);
		client.getOptions().setJavaScriptEnabled(true);
		LogFactory.getFactory().setAttribute("org.apache.commons.logging.Log",
				"org.apache.commons.logging.impl.NoOpLog");
		java.util.logging.Logger.getLogger("net.sourceforge.htmlunit").setLevel(java.util.logging.Level.OFF);
		HtmlPage page = client.getPage(new URL(homeUrl));
		HtmlElement password = (HtmlElement) page.getElementById("password");
		password.setAttribute("value", $password);
		System.out.println($password);
		HtmlElement aid = (HtmlElement) page.getElementById("aid");
		aid.setAttribute("value", $hexqq);
		System.out.println($hexqq);
		HtmlElement verifycode = (HtmlElement) page.getElementById("verifycode");
		verifycode.setAttribute("value", $verify.toUpperCase());
		System.out.println($verify.toUpperCase());
		HtmlElement submit = (HtmlElement) page.getElementById("submit");
		HtmlPage click = submit.click();
		return click.getElementById("result").asText();
	}

	public static void main(String[] args) throws FailingHttpStatusCodeException, MalformedURLException, IOException {
		System.out.println(password("00\\x00\\x00\\x00\\x41\\x7b\\xa6\\x3d", "huqiyun", "!GDN"));

	}
}

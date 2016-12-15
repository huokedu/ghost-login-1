package zz.pseas.ghost.login.qq.interfaced;

import java.net.HttpURLConnection;
import java.net.ProtocolException;

/**
 * <p>提供在请求前后，设置请求参数的接/p>
 * @category  类名
 * @since     1.0
 * 
 */
public interface SetHttpConnection{
	public String before(HttpURLConnection httpConn) throws ProtocolException;
	public String after(HttpURLConnection httpConn);
}
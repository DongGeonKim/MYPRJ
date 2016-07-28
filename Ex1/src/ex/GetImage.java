package ex;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

public class GetImage {

	public static void main(String[] args) {
		GetImage g = new GetImage();
		g.doContent();
	}

	public void doContent() {
		String m_strURL = "";
		String strPage = "";
		String strDocIrn = "";

		String strUrl = "http://img.naver.net/static/www/u/2013/0731/nmms_224940510.gif"; /** �׽�Ʈ�� �̹����� ���� */
		byte[] buf = null;
		URLConnection uCon = null;
		InputStream is = null;
		OutputStream os = null;	/** �߰� */
		try {
			System.out.println("-------Download Start------");
			URL Url;
			int nByteRead;
			int nByteWritten = 0;

			Url = new URL(strUrl);

			uCon = Url.openConnection();
			is = uCon.getInputStream();
			
			os = new FileOutputStream("C:/Users/dgkim/Desktop/imgTest.gif");	/** �߰� - ������ ���� ����̺� �� ��ġ ���� */
			
			buf = new byte[1024];
			while ((nByteRead = is.read(buf)) != -1) {
				
				//System.out.println(nByteRead);
				nByteWritten += nByteRead;
				os.write(buf, 0, nByteRead);	/** �߰� */
			}
			os.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
				os.flush();	/** �߰� */
				os.close();	/** �߰� */
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		// return buf;
	}

	private String checkNull(Object obj) {
		String returnValue = " ";
		if (obj != null && !obj.toString().equals("null") && obj.toString().length() > 0) {
			returnValue = (String) obj;
		}
		return returnValue;
	}

}
package cn.com.samcooker.spring.security.tools;

public interface UrlMatcher{
	/**
	 * 
	 * @param paramString
	 * @return
	 */
	Object compile(String paramString);
	
	/**
	 * 
	 * @param paramObject
	 * @param paramString
	 * @return
	 */
	boolean pathMatchesUrl(Object paramObject, String paramString);
	
	/**
	 * 
	 * @return
	 */
	String getUniversalMatchPattern();
	
	/**
	 * 
	 * @return
	 */
	boolean requiresLowerCaseUrl();
}
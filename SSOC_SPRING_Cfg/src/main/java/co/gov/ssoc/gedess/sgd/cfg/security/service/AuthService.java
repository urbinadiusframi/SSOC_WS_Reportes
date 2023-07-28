package co.gov.ssoc.gedess.sgd.cfg.security.service;


public interface AuthService {

	/**
     * Validate Basic Authentication.
     *
     * @param userName the user name
     * @param password the password
     * @param basicAuthHeaderValue the base 64 encoded header value
     * @return the boolean
     */
	Boolean validateBasicAuthentication(String userName, String password, String basicAuthHeaderValue);
//	Boolean validateBasicAuthentication(String basicAuthHeaderValue);

}

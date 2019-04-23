package com.theimitation.webservice.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ReadProperties {
	@Value("${myProperties}")
	String location;

	Properties prop = new Properties();
	static Logger logger = LoggerFactory.getLogger(ReadProperties.class.getName());

	public List<String> reportNameInitializer(String clientName) {
		List<String> reportNameList = null;

		InputStream inputStream = null;
		String clientPropertyName = clientName.concat(".reportList");

		try {

			try {
				inputStream = new FileInputStream(location + "dropdown.properties");
			} catch (IOException ex) {
				inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("dropdown.properties");
			}
			prop.load(inputStream);
			reportNameList = Arrays.asList((prop.getProperty(clientPropertyName).split(",")));
			// reportNameList.add("AIG");
			for (String a : reportNameList) {
				System.out.println(a);
			}
		} catch (IOException ex) {
			logger.error("dropdown.properties not found", ex);
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException ex) {
					logger.error("dropdown.properties not found", ex);
				} catch (Exception ex) {
					logger.error("dropdown.properties not found", ex);
				}
			}
		}
		return reportNameList;
	}

	public List<String> getClientName() {
		List<String> clientNameList = null;
		InputStream inputStream = null;
		try {
			// inputStream =
			//
			// String
			// filelocation=getServletContext().getInitParameter("AdministratorEmail");

			// inputStream =
			// Thread.currentThread().getContextClassLoader().getResourceAsStream(location);
			// inputStream=ReadProperties.class.getResourceAsStream(location);
			try {
				inputStream = new FileInputStream(location + "dropdown.properties");
			} catch (IOException ex) {
				inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("dropdown.properties");
			}
			prop.load(inputStream);
			clientNameList = Arrays.asList((prop.getProperty("client.clientNames").split(",")));
			for (String a : clientNameList) {
				System.out.println(a);
			}
		} catch (IOException ex) {
			logger.error("dropdown.properties not found", ex);
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException ex) {
					logger.error("dropdown.properties not found", ex);
				} catch (Exception ex) {
					logger.error("dropdown.properties not found", ex);
				}
			}
		}
		return clientNameList;
	}

	public String[] dbDetailsReader(String clientName) {
		String[] dbDetails = new String[3];
		InputStream inputStream = null;
		try {
			// inputStream =
			//
			// String
			// filelocation=getServletContext().getInitParameter("AdministratorEmail");

			// inputStream =
			// Thread.currentThread().getContextClassLoader().getResourceAsStream(location);
			// inputStream=ReadProperties.class.getResourceAsStream(location);
			try {
				inputStream = new FileInputStream(location + "dbdetails.properties");
			} catch (IOException ex) {
				inputStream = Thread.currentThread().getContextClassLoader()
						.getResourceAsStream("dbdetails.properties");
			}
			prop.load(inputStream);
			dbDetails[0] = prop.getProperty(clientName + ".url");
			dbDetails[1] = prop.getProperty(clientName + ".username");
			dbDetails[2] = prop.getProperty(clientName + ".password");
			for (String a : dbDetails) {
				System.out.println(a);
			}
		} catch (IOException ex) {
			logger.error("dbdetails.properties not found", ex);
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException ex) {
					logger.error("dbdetails.properties not found", ex);
				} catch (Exception ex) {
					logger.error("dbdetails.properties not found", ex);
				}
			}
		}
		return dbDetails;
	}

	public String[] ldapDetailsReader() {
		String[] ldapDetails = new String[3];
		InputStream inputStream = null;
		try {
			// inputStream =
			//
			// String
			// filelocation=getServletContext().getInitParameter("AdministratorEmail");

			// inputStream =
			// Thread.currentThread().getContextClassLoader().getResourceAsStream(location);
			// inputStream=ReadProperties.class.getResourceAsStream(location);
			try {
				inputStream = new FileInputStream(location + "ldap.properties");
			} catch (IOException ex) {
				inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("ldap.properties");
			}
			prop.load(inputStream);
			ldapDetails[0] = prop.getProperty("url");
			ldapDetails[1] = prop.getProperty("baseprefix");
			ldapDetails[2] = prop.getProperty("factory");
		} catch (IOException ex) {
			logger.error("ldap.properties not found", ex);
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException ex) {
					logger.error("ldap.properties not found", ex);
				} catch (Exception ex) {
					logger.error("ldap.properties not found", ex);
				}
			}
		}
		return ldapDetails;
	}

	public String getPropFileLocation() {
		String propLocation = null;
		InputStream inputStream = null;
		try {
			// inputStream =
			//
			// String
			// filelocation=getServletContext().getInitParameter("AdministratorEmail");

			// inputStream =
			// Thread.currentThread().getContextClassLoader().getResourceAsStream(location);
			// inputStream=ReadProperties.class.getResourceAsStream(location);
			inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("propLocation.properties");
			prop.load(inputStream);
			propLocation = prop.getProperty("prop.location");
			// System.out.println(propLocation);
		} catch (IOException ex) {
			logger.error("propLocation.properties not found", ex);
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException ex) {
					logger.error("propLocation.properties not found", ex);
				} catch (Exception ex) {
					logger.error("propLocation.properties not found", ex);
				}
			}
		}
		return propLocation;
	}

	public String getMessage(String type,String code) {
		String message = "";
		if (location == null || location == "") {
			location = getPropFileLocation();
		}
		InputStream inputStream = null;

		try {

			try {
				inputStream = new FileInputStream(location + "messages.properties");
			} catch (IOException ex) {
				inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("messages.properties");
			}
			prop.load(inputStream);
			message = prop.getProperty(type+"."+code);
		} catch (IOException ex) {
			logger.error("dropdown.properties not found", ex);
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException ex) {
					logger.error("dropdown.properties not found", ex);
				} catch (Exception ex) {
					logger.error("dropdown.properties not found", ex);
				}
			}
		}
		return message;
	}
}

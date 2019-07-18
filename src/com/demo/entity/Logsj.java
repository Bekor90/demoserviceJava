package com.demo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings("rawtypes")
public class Logsj implements java.io.Serializable {
	
	@JsonProperty(value="lus")
	private String logusuario;
	@JsonProperty(value="lip")
	private String logip;
	@JsonProperty(value="ltp")
	private String logtipo;
	@JsonProperty(value="lpa")
	private String logparametro;
	@JsonProperty(value="lre")
	private String logrespuesta;

	public Logsj() {
	}
		
	public Logsj(String logusuario, String logip, String logtipo, String logparametro, String logrespuesta) {
		this.logusuario = logusuario;
		this.logip = logip;
		this.logtipo = logtipo;
		this.logparametro = logparametro;
		this.logrespuesta = logrespuesta;
	}

	public String getLogusuario() {
		return logusuario;
	}
	public void setLogusuario(String logusuario) {
		this.logusuario = logusuario;
	}
	public String getLogip() {
		return logip;
	}
	public void setLogip(String logip) {
		this.logip = logip;
	}
	public String getLogtipo() {
		return logtipo;
	}
	public void setLogtipo(String logtipo) {
		this.logtipo = logtipo;
	}
	public String getLogparametro() {
		return logparametro;
	}
	public void setLogparametro(String logparametro) {
		this.logparametro = logparametro;
	}
	public String getLogrespuesta() {
		return logrespuesta;
	}
	public void setLogrespuesta(String logrespuesta) {
		this.logrespuesta = logrespuesta;
	}	
	
}

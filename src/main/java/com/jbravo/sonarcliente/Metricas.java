package com.jbravo.sonarcliente;

public class Metricas {

	private Double blocker_violations;

	private Double critical_violations;

	private Double major_violations;

	public Double getBlocker_violations() {
		return blocker_violations;
	}

	public void setBlocker_violations(final Double blocker_violations) {
		this.blocker_violations = blocker_violations;
	}

	public Double getCritical_violations() {
		return critical_violations;
	}

	public void setCritical_violations(final Double critical_violations) {
		this.critical_violations = critical_violations;
	}

	public Double getMajor_violations() {
		return major_violations;
	}

	public void setMajor_violations(final Double major_violations) {
		this.major_violations = major_violations;
	}

}

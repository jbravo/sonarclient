package com.jbravo.sonarcliente;

import java.util.List;

import org.sonar.wsclient.Sonar;
import org.sonar.wsclient.services.Measure;
import org.sonar.wsclient.services.Metric;
import org.sonar.wsclient.services.MetricQuery;
import org.sonar.wsclient.services.ResourceQuery;

/**
 * Hello world!
 * 
 */
public class App {


	private static String[] moduleNames = { "commons-collections:commons-collections"};

	private static String[] metricsName = { "lines", "coverage", "duplicated_lines_density", "blocker_violations", "critical_violations",
			"major_violations" };

	public static void main(final String[] args) {
		System.out.println("========> Comienza el acceso al sonar.");


		final Sonar sonar = Sonar.create("http://nemo.sonarsource.org");

		final List<Metric> metrics = sonar.findAll(MetricQuery.all());

		for (final Metric metric : metrics) {
			System.out.println(metric.getKey());
		}

		for (final String moduleName : moduleNames) {
			System.out.print("Module: " + moduleName + " --> ");

			final ResourceQuery resourceQuery = new ResourceQuery(moduleName);
			resourceQuery.setMetrics(metricsName);
			final List<Measure> measures = sonar.find(resourceQuery).getMeasures();

			for (final Measure measure : measures) {
				System.out.println(measure.getMetricKey() + " - " + measure.getValue());

			}

		
		}	

		System.out.println(" ================> Fin del acceso al sonar.....");
	}
}

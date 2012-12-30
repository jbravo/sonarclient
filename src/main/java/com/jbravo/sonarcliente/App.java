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

	/*private static String[] moduleNames = { "gnf.zeus.sb.batch:zeus-sb-batch-parent:Unificacion", "gnf.gps.comun:comun-jee:Unificacion",
			"gnf.sb:zeus-sb-multimodule:Unificacion", "gnf.eps.cartera:cartera-jee:Unificacion",
			"gnf.gps.cobrofinanciacionfacturacion:cobrofinanciacionfacturacion-jee:Unificacion",
			"gnf.gps.atcliente:atcliente-jee:Unificacion", "gnf.eps.comercializacionventas:comercializacionventas-jee:Unificacion",
			"gnf.eps.gestionpotencial:gestionpotencial-jee:Unificacion", "gnf.gps.operaciones:operaciones-jee:Unificacion",
			"gnf.gps.contratacionintercambios:contratacionintercambios-jee:Unificacion",
			"gnf.gps.gestiontecnica:gestiontecnica-jee:Unificacion" };*/
	
	private static String[] moduleNames = { "commons-collections:commons-collections"};

	private static String[] metricsName = { "lines", "coverage", "duplicated_lines_density", "blocker_violations", "critical_violations",
			"major_violations" };

	public static void main(final String[] args) {
		System.out.println("========> Comienza el acceso al sonar.");


		final Sonar sonar = Sonar.create("http://nemo.sonarsource.org");

		/*
		 * final PropertyQuery query = new PropertyQuery(); final List<Property> resources = sonar.findAll(query); for (final Property
		 * resource : resources) { System.out.println(resource); }
		 */

		/*
		 * assertThat(sonar.find(new ResourceQuery(PROJECT_STRUTS)).getName(), is("Struts")); assertThat(sonar.find(new
		 * ResourceQuery(PROJECT_STRUTS)).getVersion(), is("1.3.9")); assertThat(sonar.find(new ResourceQuery(MODULE_CORE)).getName(),
		 * is("Struts Core"));
		 */

		// http://barzeuspclx05.indra.es:9000/api/resources?resource=gnf.gps.cobrofinanciacionfacturacion%3Acobrofinanciacionfacturacion-jee
		/*
		 * <resources> <resource> <id>1</id> <key> gnf.gps.cobrofinanciacionfacturacion:cobrofinanciacionfacturacion-jee </key>
		 * <name>cobrofinanciacionfacturacion-jee</name> <lname>cobrofinanciacionfacturacion-jee</lname> <scope>PRJ</scope>
		 * <qualifier>TRK</qualifier> <lang>java</lang> <version>4.58.0-SNAPSHOT</version> <date>2012-12-13T03:01:50+0100</date> </resource>
		 * </resources>
		 */
		final List<Metric> metrics = sonar.findAll(MetricQuery.all());

		for (final Metric metric : metrics) {
			// System.out.println(metric.getName());
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

			/*
			 * for (final String metricName : metricsName) { System.out.println(metricName + " " + measures); }
			 */

			/*
			 * System.out.println(sonar.find(resourceQuery).getMeasures());
			 * System.out.println(sonar.find(resourceQuery).getMeasures().get(0).getValue());
			 */
		}

		// Resource res = new Resource().setKey("gnf.gps.contratacionintercambios:contratacionintercambios-jee");
		// Resource struts = sonar.find(ResourceQuery.createForResource(res, "coverage", "lines", "violations"));
		// Resource struts = sonar.find(ResourceQuery.createForMetrics("gnf.gps.contratacionintercambios:contratacionintercambios-jee",
		// "coverage", "lines", "violations"));
		// struts.getMeasure("coverage");

		/*
		 * .createForMetrics( "gnf.gps.cobrofinanciacionfacturacion:cobrofinanciacionfacturacion-jee" , "coverage", "lines", "violations"));
		 * struts.getMeasure("coverage");
		 */

		System.out.println(" ================> Fin del acceso al sonar.....");
	}
}

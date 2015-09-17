package com.sparg.java.dm.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * @author: vimal.sengoden
 * Date: 8/12/2015
 * Time: 11:33 AM
 */
public class TestDBConnection {

    public static void main(String[] args) throws Exception {
        /*Connection con = DriverManager.getConnection("jdbc:mysql:fabric://10.1.160.14:32274/nmi_r5?fabricUsername=admin&fabricPassword=3EgNiiPun7&fabricServerGroup=devha",
                "nmi",
                "dUvMYjXs"); //Fabric*/
        Connection con = DriverManager.getConnection("jdbc:jtds:sqlserver://10.1.160.106/Cogent_Dev;instance=MSSQLSERVER", "svc_axis_cogent_dev", "Step2IT2105");  // Local
        //Connection con = DriverManager.getConnection("jdbc:mysql://10.1.160.26/nmi_r5", "nmi", "dUvMYjXs"); // DEV
        Statement statement = con.createStatement();
        //ResultSet rs = statement.executeQuery("select * from customer");
        //ResultSetToObjectMapper<Customer> rowMapper = new SourceFieldMapper(new EntityManagerFactory().getInstance(Customer.class));
        //Set<Customer> customers = rowMapper.toObjects(rs);
        //System.out.println(customers.size());
    }

}

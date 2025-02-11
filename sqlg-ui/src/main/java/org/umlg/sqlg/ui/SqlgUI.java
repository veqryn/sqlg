package org.umlg.sqlg.ui;

import org.umlg.sqlg.structure.SqlgGraph;
import spark.Spark;

public class SqlgUI {

    private SqlgGraph sqlgGraph;
    public static SqlgUI INSTANCE = null;

    public static void initialize(int port) {
        if (INSTANCE == null) {
            SparkResources.staticResources();
            if (port != -1) {
                Spark.port(port);
            }
            SparkResources.websocket();
            SparkResources.resources();
            Spark.awaitInitialization();
        }

    }

    public static void initialize() {
        initialize(-1);
    }

    public static void set(SqlgGraph sqlgGraph) {
        if (INSTANCE == null) {
            INSTANCE = new SqlgUI();
        }
        INSTANCE.setSqlgGraph(sqlgGraph);
    }

    public static void stop() {
        INSTANCE = null;
        Spark.stop();
    }

    private SqlgUI() {
    }

    public SqlgGraph getSqlgGraph() {
        return sqlgGraph;
    }

    private void setSqlgGraph(SqlgGraph sqlgGraph) {
        this.sqlgGraph = sqlgGraph;
    }

}

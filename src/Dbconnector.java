import java.sql.*;

class Dbconnector {
    public static final String PARAMS = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    public static final String DEFAULT_DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";
    public static String hostname = "localhost";
    public static String dbName = "javadbtest";
    public static int port = 3306;
    public static final String DEFAULT_URL = "jdbc:mysql://"+ hostname +":"+port+"/"+dbName+PARAMS;
    private static final String DEFAULT_USERNAME = "glew";
    private static final String DEFAULT_PASSWORD = "password";

    private Connection connection;

    public Dbconnector() {
        this.connection = createConnection();
    }

    public Connection createConnection() {
        Connection connection = null;
        try {
            Class.forName(DEFAULT_DRIVER_CLASS);
            connection = DriverManager.getConnection(DEFAULT_URL, DEFAULT_USERNAME, DEFAULT_PASSWORD);

        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
        return connection;
    }

    public String getStory(int id){
        PreparedStatement ps = null;
        ResultSet rs = null;
        String story = null;
        try {
            ps = connection.prepareStatement("SELECT text FROM story WHERE id = " + id);
            rs = ps.executeQuery();
            //While behövs inte eftersom den bara går igenom 1 gång
            if (rs.next()) {
                story = rs.getString("text");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return story;
    }

    /*
    Tar id och text från 2 fält i storylinks med samma storyid och kollar om de har jämnt eller ojämnt id
    för att bestämma om de ska vara den vänstra eller högra knappen
     */
    public String[] getButtonTexts(int id) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        String buttonTexts[] = new String[2];
        try {
            ps = connection.prepareStatement("SELECT id, text FROM storylinks WHERE storyid = " + id);
            rs = ps.executeQuery();
            // Har 2 linjer, while behövs så att den går igenom alla
            while (rs.next()) {
                int idnumber = rs.getInt("id");
                if(idnumber % 2 == 0) {
                    buttonTexts[1] = rs.getString("text");
                } else {
                    buttonTexts[0] = rs.getString("text");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return buttonTexts;
    }
}
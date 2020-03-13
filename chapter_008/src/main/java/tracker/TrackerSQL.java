package tracker;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.logging.ErrorManager;

public class TrackerSQL implements ITracker, AutoCloseable {
    private static final ErrorManager LOG = null;
    private Connection connection;
    //private void item;

    public TrackerSQL(Connection connection){
    this.connection = connection;
}
    public boolean init() {
        try (InputStream in = TrackerSQL.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            this.connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
        return this.connection != null;
    }


        @Override
        public Item add(Item item) {
            String temp = "";
            try (PreparedStatement st =  this.connection
                    .prepareStatement("insert into items (id, item_name) values (?, ?)")) {
                temp = generateId();
                st.setString(1, temp);
                st.setString(2, item.getName());
                st.execute();
            } catch (SQLException r) {
                r.printStackTrace();
            }
            item.setId(temp);
            return item;
        }

        @Override
        public boolean replace(String id, Item item) {
            boolean answer = false;
            try (PreparedStatement st = connection
                    .prepareStatement("update items set item_name = ? where id = ?")) {
                st.setString(1, item.getName());
                st.setString(2, id);
                answer = st.executeUpdate() > 0;
            } catch (SQLException r) {
                r.error("Replace item error", r);
            }
            return answer;
        }

        @Override
        public boolean delete(String id) {
            boolean answer = false;
            try (PreparedStatement st = connection.prepareStatement("delete from items where id = ?")) {
                st.setString(1, id);
                answer = st.executeUpdate() > 0;
            } catch (SQLException r) {
                r.error("Delete item error", r);
            }
            return answer;
        }

        @Override
        public Item[] findAll() {
            List<Item> temp = new ArrayList<>();
            try (Statement st = connection.createStatement();
                 ResultSet anwer = st.executeQuery("select * from items")) {
                while (anwer.next()) {
                    Item tempItem = new Item("name", anwer.getString("item_name"));
                    tempItem.setId(anwer.getString("id"));
                    temp.add(tempItem);
                }
            } catch (SQLException r) {
                LOG.error("FindAll item error", r);
            }
            Item[] tempArray = new Item[temp.size()];
            temp.toArray(tempArray);
            return tempArray;

        }

        @Override
        public Item[] findByName(String key) {
            List<Item> temp = new ArrayList<>();
            try (PreparedStatement st = connection
                    .prepareStatement("select * from items where item_name =?")) {
                st.setString(1, key);
                try (ResultSet anwer = st.executeQuery()) {
                    while (anwer.next()) {
                        Item tempItem = new Item("name", anwer.getString("item_name"));
                        tempItem.setId(anwer.getString("id"));
                        temp.add(tempItem);
                    }
                }
            } catch (SQLException r) {
                LOG.error("findByName item error", r);
            }

            Item[] tempArray = new Item[temp.size()];
            temp.toArray(tempArray);
            return tempArray;
        }

        @Override
        public Item findById(String id) {
            Item tempItem;
            try (PreparedStatement st = connection.prepareStatement("select * from items where id =?")) {
                st.setString(1, id);
                try (ResultSet anwer = st.executeQuery()) {
                    while (anwer.next()) {
                        tempItem = new Item("name", anwer.getString("item_name"));
                        tempItem.setId(anwer.getString("id"));
                        return tempItem;
                    }
                }
            } catch (SQLException r) {
                LOG.error("FindByName item error", r);
            }
            return null;
        }

        @Override
        public void close() throws Exception {
            connection.close();
        }

        private String generateId() {
            Random korea = new Random();
            return String.valueOf(System.currentTimeMillis() + korea.nextLong());
        }
    }






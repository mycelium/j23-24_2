package ru.spbstu.lesson.java;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PhilosophersDAO {
	private Logger logger = LoggerFactory.getLogger(PhilosophersDAO.class);

	private static PhilosophersDAO instance;
	private static Object createSingletoneMonitor = new Object();

	private PhilosophersDAO() {

		try (Connection connect = DriverManager.getConnection("jdbc:sqlite:database.db")) {
			Statement statement = connect.createStatement();

			String createPhilosophersTableQuery = "CREATE TABLE IF NOT EXISTS Philosophers (`id` INTEGER PRIMARY KEY, `name` TEXT NOT NULL);";
			statement.execute(createPhilosophersTableQuery);

			String clearPhilosophersTableQuery = "DELETE FROM Philosophers";
			statement.execute(clearPhilosophersTableQuery);

			String insertPhilosophersQuery = "INSERT INTO Philosophers(name) values(?);";
			var names = List.of("John", "Robert", "Dijkstra", "Olaf", "Andrew");

			PreparedStatement preparedStatement = connect.prepareStatement(insertPhilosophersQuery);

			names.forEach((name) -> {
				try {
					preparedStatement.setString(1, name);
					preparedStatement.execute();
				} catch (SQLException e) {
					logger.error("", e);
				}
			});

		} catch (SQLException e) {
			logger.error("", e);
		}
	}

	public List<String> getNames() {
		try (Connection connect = DriverManager.getConnection("jdbc:sqlite:database.db")) {
			Statement statement = connect.createStatement();

			String selectAllPhilosophersQuery = "SELECT name FROM Philosophers;";
			ResultSet selectedNames = statement.executeQuery(selectAllPhilosophersQuery);

			var philosophersNames = new ArrayList<String>();

			while (selectedNames.next()) {
				String philosopherName = selectedNames.getString(1);
				philosophersNames.add(philosopherName);
			}
			return philosophersNames;
		} catch (SQLException e) {
			logger.error("", e);
		}
		return List.of();
	}

	public static PhilosophersDAO getInstance() {
		if (instance == null) {
			synchronized (createSingletoneMonitor) {
				if (instance == null) {
					instance = new PhilosophersDAO();
				}
			}
		}
		return instance;
	}
}

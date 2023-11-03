package com.scoreboard;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String jdbcUrl = "jdbc:mysql://localhost:3306/greekforgreekproject";
		String username = "root";
		String password = "master#123";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(jdbcUrl, username, password);
		Statement st = con.createStatement();
		Boolean flag = true;
		while (flag) {
			System.out.println("Enter your Choice");
			System.out.println("1 - view the record");
			System.out.println("2 - create the record");
			System.out.println("3 - update the record");
			System.out.println("4 - delete the record");
			System.out.println("5 - exit");
			int choice = sc.nextInt();
			switch (choice) {
			case 1: {
				ResultSet rS = st.executeQuery("select * from scoreboard");
				while (rS.next()) {
					System.out.println(rS.getInt(1) + " " + rS.getString(2) + " " + rS.getInt(3) + " " + rS.getInt(4));
				}
				System.out.println("successful print the score board");
				break;

			}
			case 2:
				System.out.println("enter the id of the player");
				int id = sc.nextInt();
				System.out.println("enter the name of the player");
				String name = sc.next();
				System.out.println("enter the runs ");
				int score = sc.nextInt();
				System.out.println("Enter the no of balls played");
				int balls = sc.nextInt();
				int r = st.executeUpdate(
						"INSERT INTO scoreboard VALUE(" + id + ", '" + name + "', " + score + ", " + balls + ")");

				System.out.println("Successfull insert the data");
				break;
			case 3:
				// update score table set runs and balls based on id
				System.out.println("enter the id");
				int id1 = sc.nextInt();
				System.out.println("enter new score");
				int newrun = sc.nextInt();
				System.out.println("enter the balls played recently");
				int newBalls = sc.nextInt();
				st.executeUpdate(
						"UPDATE scoreboard SET Runs = " + newrun + ", NoofBalls = " + newBalls + " WHERE id = " + id1);

				System.out.println("score was updated on this playerID" + id1);
				break;
			case 4:
				System.out.println("enter the player id who want to delete it");
				int id2 = sc.nextInt();
				st.executeUpdate("DELETE FROM scoreboard WHERE id = " + id2);
				System.out.println("remove this id" + id2);
				break;

			default:
				flag = false;
				System.out.println("final score");
				break;
			}

		}
	}

}
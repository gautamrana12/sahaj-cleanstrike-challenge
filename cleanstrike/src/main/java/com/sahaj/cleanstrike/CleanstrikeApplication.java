package com.sahaj.cleanstrike;

import com.sahaj.cleanstrike.service.ICarromBoardGame;
import com.sahaj.cleanstrike.service.impl.CarromBoardGame;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CleanstrikeApplication {

	public static void main(String[] args) {
		System.out.println("Let's play Game...");
		CleanstrikeApplication cleanstrikeApplication = new CleanstrikeApplication();
		cleanstrikeApplication.start();

	}
	// Logic for Winner or Looser or Draw

	public void start() {
		ICarromBoardGame iCarromBoardGame = new CarromBoardGame();
		iCarromBoardGame.playCarrom();
	}
}

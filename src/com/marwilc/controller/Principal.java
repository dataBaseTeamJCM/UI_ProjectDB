package com.marwilc.controller;

import java.awt.EventQueue;

import com.marwilc.views.Login;

class Principal{

		public static void main(String[] args){
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						Login gg = new Login();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
			
		}

}
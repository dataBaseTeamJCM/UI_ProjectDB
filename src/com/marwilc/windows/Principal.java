package com.marwilc.windows;

import java.awt.EventQueue;

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
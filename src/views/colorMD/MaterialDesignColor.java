package views.colorMD;

import java.awt.Color;

public class MaterialDesignColor extends Color{
	
	public MaterialDesignColor(String hexColor) {
		super(MaterialDesignColor.hex_to_int(hexColor));
		// TODO Auto-generated constructor stub
		
	}
	
	private static int hex_to_int(String hex)
	{
		return(Integer.parseInt(hex,16));
	}
	
}

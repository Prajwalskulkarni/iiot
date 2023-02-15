/**
 * 
 */
package com.beauto.iiotconnx.util;

import java.util.UUID;

/**
 * @author User
 *
 */
public class GenerateUUID {
	
	
	public static String UUID()
	{
		UUID uuid = UUID.randomUUID();
		
		return uuid.toString();
	}

}

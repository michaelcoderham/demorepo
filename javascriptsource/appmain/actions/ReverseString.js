// This file was generated by Mendix Studio Pro.
//
// WARNING: Only the following code will be retained when actions are regenerated:
// - the import list
// - the code between BEGIN USER CODE and END USER CODE
// - the code between BEGIN EXTRA CODE and END EXTRA CODE
// Other code you write will be lost the next time you deploy the project.
import { Big } from "big.js";

// BEGIN EXTRA CODE
// END EXTRA CODE

/**
 * @param {string} parameter
 * @returns {Promise.<string>}
 */
export async function ReverseString(parameter) {
	// BEGIN USER CODE
	var newString = "";
    for (var i = parameter.length - 1; i >= 0; i--) {
        newString += parameter[i];
    }
    return newString;
	// END USER CODE
}

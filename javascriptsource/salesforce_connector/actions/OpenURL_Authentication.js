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
 * @param {MxObject} authentication
 * @param {string} microflowName
 * @returns {Promise.<boolean>}
 */
export async function OpenURL_Authentication(authentication, microflowName) {
	// BEGIN USER CODE
	return new Promise(function(resolve,reject){
        mx.data.action({
        params: {
            applyto: "selection",
            actionname: microflowName,
            guids: [authentication.getGuid()]
        },
        callback: function(url) {
    window.open(url,"_self");
            resolve(true);
        },
        error: function(error) {
            console.error(error);
            reject(false);
        }
    });
  });
	// END USER CODE
}

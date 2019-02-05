/**
 * Tienda.js
 *
 * @description :: A model definition represents a database table/collection.
 * @docs        :: https://sailsjs.com/docs/concepts/models-and-orm/models
 */

module.exports = {

  attributes: {
	nombre:'string',
	direccion:'string',
	fechaApertura:'string',
	ruc:'string',
	matriz:'string',
	productos:{
		collection:'producto',
		via:'owner'
	}		
  },

};


/**
 * Producto.js
 *
 * @description :: A model definition represents a database table/collection.
 * @docs        :: https://sailsjs.com/docs/concepts/models-and-orm/models
 */

module.exports = {

  attributes: {
	  numeroProducto:'string',
	  nombre:'string',
	  descripcion:'string',
	  precio:'string',
	  fechaLanzamiento:'string',
	  aniosGarantia:'string',
	  owner: {
		model:'tienda'
	  }
 },

};


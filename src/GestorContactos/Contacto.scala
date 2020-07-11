package GestorContactos



abstract class Contacto (val nombre:String, val edad: Int, val telefono: String) {
  
   def getNombre():String
   def getEdad():Int
   def getTelefono():String
}

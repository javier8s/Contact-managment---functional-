package GestorContactos

object GestorApp extends App{
  var i = 1
  while(i!=0){
    println("Bienvenido a la gestión de contactos: ")
    println("    - 1  Insertar contacto.")
    println("    - 2  Eliminar contacto.")
    println("    - 3  Mostrar contactos.")
    println("    - 4  Verificar si existe contacto.")
    println("    - 5  Verificar el primero de la lista (el último contacto).")
    println("    - 6  Obtener por indice.")
    println("    - 7  Buscar a todos los contactos con un nombre.")
    println("    - 8  Actualizar contacto.")
    println("    - 9  Inserción por orden.")
    println("    - 10 Ordenar.")
    println("    - 11 Llenar con datos de prueba.")
    println("    - 0  Salir.")
    println("\nEscoga su elección:")
    i = MyInput.Int()
    i match{
      case 1=> GestorContactos.introducirContacto(0)
      case 2=> GestorContactos.eliminarContacto()
      case 3=> GestorContactos.mostrar()
      case 4=> GestorContactos.verificarContacto()
      case 5=> GestorContactos.introducirContacto(1)
      case 6=> GestorContactos.obtIndex()
      case 7=> GestorContactos.encontrarTodos()
      case 8=> GestorContactos.introducirContacto(2)
      case 9=> GestorContactos.introducirListaContacto()
      case 10=>GestorContactos.ordenar()
      case 11=>GestorContactos.utilizarPrueba()
      case _ => 
    }
    
  }
}
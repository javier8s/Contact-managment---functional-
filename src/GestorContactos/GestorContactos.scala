package GestorContactos
import scala.io.StdIn.readInt
import scala.io.StdIn.readLine
object GestorContactos {
  private var contactos: List[Contacto] = List()
   def insertar(c:Contacto){
  contactos= contactos.::(c)
  }
   def eliminar(n:String){
     contactos=contactos.filter(x => x.getNombre()!=n)
     }
   def mostrar(){
     println("\nLista de cotactos: ");contactos foreach{x =>println("Nombre: "+x.getNombre()," Edad : "+x.getEdad()," Telefono : "+x.getTelefono())}
     }
   def existe(n :String):Boolean={contactos.exists(x => x.getNombre()==n)}
   def encontrarPrim(c:Contacto):Option[Contacto]={
     if(c.getNombre()==contactos.head.getNombre())Option(contactos.head)else None
     }   
   def recuperar(i:Int):Option[Contacto]={
     contactos.lift(i)
     }
   def econtrarTodos(n:String):List[Contacto]={
     contactos.filter(x => x.getNombre()==n)
     }
   def actualizar(i:Int,c:Contacto){
     contactos = contactos.updated(i, c)
     }
   def insertarOrd(l:List[Contacto]){
     def insertarPorBloques(x:Contacto){
        var n = x.getNombre()
        var e = x.getEdad()
        contactos =List(contactos.filter(x => x.getNombre()<n),contactos.filter(x => (x.getNombre()==n) && (x.getEdad()<=e)),List(x),contactos.filter(x => (x.getNombre()==n) && (x.getEdad()>e)),contactos.filter(x => x.getNombre()>n)).flatten
     }
     contactos=List(contactos,l).flatten.sortWith((x,y)=>(x.getNombre()<y.getNombre() || x.getEdad()<y.getEdad()))
   }
   def ordenar(){
     contactos= contactos.sortWith((x,y)=>(x.getNombre()<y.getNombre() || x.getEdad()<y.getEdad()))
   }
   def introducirListaContacto(){
     val l = List()
     var i =1
     while(i!=0){
       println("Introduce el nombre.")
       val n = readLine()
       println("Introduce la edad.")
       val e = readInt()
       println("Introduce el telefono.")
       val t = readLine()
       println("Introduce el numero de familiar.")
       println("  - 1 Padre.")
       println("  - 2 Madre.")
       println("  - 3 Tio.")
       println("  - 4 Tia.")
       println("  - 5 Hijo.")
       println("  - 6 Hija.")
       println("  - 7 Hermano.")
       println("  - 8 Hermana.")
       val f = readInt()
       l.::(introducirFamiliar(n,e,t,f))
       println("Pulsa 0 para acabar.")
       i = readInt()
     }
     insertarOrd(l)
   }
   def introducirFamiliar(n:String,e:Int,t:String,f:Int):Contacto={
     f match{
           case 1=> new EsFamilia(n,e,t,Padre)
           case 2=> new EsFamilia(n,e,t,Madre)
           case 3=> new EsFamilia(n,e,t,Tio)
           case 4=> new EsFamilia(n,e,t,Tia)
           case 5=> new EsFamilia(n,e,t,Hijo)
           case 6=> new EsFamilia(n,e,t,Hija)
           case 7=> new EsFamilia(n,e,t,Hermano)
           case 8=> new EsFamilia(n,e,t,Hermana)
           case _=> new EsFamilia(n,e,t,Tio)
         } 
   }
   
   def introducirContacto(opt:Int){
     println("Introduce el nombre.")
     val n = readLine()
     println("Introduce la edad.")
     val e = readInt()
     println("Introduce el telefono.")
     val t = readLine()
     println("Introduce el numero de familiar.")
     println("  - 1 Padre.")
     println("  - 2 Madre.")
     println("  - 3 Tio.")
     println("  - 4 Tia.")
     println("  - 5 Hijo.")
     println("  - 6 Hija.")
     println("  - 7 Hermano.")
     println("  - 8 Hermana.")
     val f = readInt()
     opt match{
       case 0 =>insertar(introducirFamiliar(n,e,t,f))
       case 1 =>println(encontrarPrim(introducirFamiliar(n,e,t,f)))
       case 2 =>{
         println("Dime el indice a cambiar.")
         val i = readInt()
         actualizar(i,introducirFamiliar(n,e,t,f))
       }
     }
   }
   
   def eliminarContacto(){
     println("Introduce el nombre para ser eliminado.")
     val n = readLine()
     eliminar(n)
   }
   def verificarContacto(){
     println("Introduce el nombre para ser verificado.")
     val n = readLine()
     println(existe(n))
   }
    def encontrarTodos(){
     println("Introduce el nombre para ser visualizado.")
     val n = readLine()
     println(econtrarTodos(n))
   }
   def obtIndex(){
     println("Introduce el indice.")
     val e = readInt()
     println(recuperar(e))
   }
   
   def utilizarPrueba(){
     
    val c1 = new EsFamilia("Juan",40,"354126786",Padre)
    val c2 = new EsFamilia("Pedro",15,"156126786",Hijo)
    val c3 = new EsFamilia("Sara",15,"156856786",Hija)
    val c4 = new EsFamilia("Alvaro",15,"156856786",Hijo)
    insertarOrd(List(c1,c2,c3,c4,c2))
   }
}




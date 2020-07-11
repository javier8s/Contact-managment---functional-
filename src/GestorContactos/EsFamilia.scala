package GestorContactos

class EsFamilia (override val nombre:String,override val edad: Int, override val telefono:String,val familiar:Familia) extends Contacto(nombre,edad, telefono){
  private var n = nombre
  private var e = edad
  private var t = telefono
  private var f = familiar
  
  override def getNombre():String={
     return n;  
  }
  
  override def getEdad():Int={
    return e
    
  }
  
  override def getTelefono():String={
    return t
  }
  
  override def toString():String={
     return n+e+t
  }
  
  def getFamiliar():Option[Familia]= f match{
    case null => None
    case _ => Option(f)
  }
  
  override def equals(c:Any ):Boolean={
    if(c.isInstanceOf[Contacto]){
      (this.getNombre()==c.asInstanceOf[Contacto].getNombre())
    } 
     false
  }
  
}
package GestorContactos

sealed trait Familia
case object Padre extends Familia
case object Madre extends Familia
case object Hermano extends Familia
case object Hermana extends Familia
case object Tio extends Familia
case object Tia extends Familia
case object Hijo extends Familia
case object Hija extends Familia

// =====================================================================
// Ejercicio 2: Cargar diccionarios de entidades
// =====================================================================

/**
 * Responsable de cargar colecciones de entidades nombradas desde archivos.
 *
 * Un diccionario es un archivo de texto plano donde cada línea contiene
 * el nombre de una entidad conocida del mismo tipo.
 *
 * Ejemplo — data/people.txt:
 *   Martin Odersky
 *   Alan Turing
 *   Ada Lovelace
 *
 * Ejemplo — data/languages.txt:
 *   Scala
 *   Python
 *   Haskell
 */
import scala.io.Source
//import NamedEntity._

object Dictionary {

  /**
   * Lee un archivo de diccionario y crea una lista de entidades del tipo indicado.
   *
   * @param filePath   ruta al archivo de diccionario (ej: "data/people.txt")
   * @param entityType tipo de entidad: "Person", "University", "ProgrammingLanguage", etc.
   * @return lista de NamedEntity del tipo correspondiente
   *
   * TODO (Ejercicio 2): Implementar este método.
   *
   *   Pasos sugeridos:
   *     1. Leer las líneas del archivo
   *     2. Para cada línea, crear la instancia de la clase correcta
   *     3. Retornar la lista de entidades creadas
   *
   *   Para crear la clase correcta según el tipo se puede usar match:
   *
   */
  def loadFromFile(filePath: String, entityType: String): List[NamedEntity] = {
    val source = Source.fromFile(filePath)

    val lineas = try {
      source.getLines().toList

    } finally {
      source.close()
    }

    entityType match {
    case "person" => lineas.map(linea => new Person(linea))
    case "organization" => lineas.map(linea => new Organization(linea))
    case "university" => lineas.map(linea => new University(linea))
    case "place" => lineas.map(linea => new Place(linea))
    case "technology" => lineas.map(linea => new Technology(linea))
    case "languages" => lineas.map(linea => new ProgrammingLanguage(linea))
    case _ => List()
    }
  }

  /**
   * Carga todos los diccionarios disponibles y combina sus entidades.
   *
   * @return lista con todas las entidades de todos los diccionarios
   *
   * TODO (Ejercicio 2): Implementar este método.
   * languages organizations people places universities
   *
   */
  def loadAll(): List[NamedEntity] = {
    
    val en1 = loadFromFile("data/places.txt","place")
    val en2 = loadFromFile("data/languages.txt","languages")
    val en3 = loadFromFile("data/people.txt","person")
    val en4 = loadFromFile("data/universities.txt","university")
    val en5 = loadFromFile("data/organizations.txt","organization")
    val entidades = List.concat(en1, en2, en3, en4, en5)

     entidades

  }
}

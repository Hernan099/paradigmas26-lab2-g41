// =====================================================================
// Ejercicio 6: Integración del sistema completo
// =====================================================================

object Main {
  def main(args: Array[String]): Unit = {

    // ------------------------------------------------------------------
    // Paso 1: Cargar diccionarios
    // ------------------------------------------------------------------
    // TODO (Ejercicio 2)
    val dictionary: List[NamedEntity] = loadAll()

    println(s"Diccionario cargado: ${dictionary.size} entidades.\n")

    // ------------------------------------------------------------------
    // Paso 2: Descargar posts
    // ------------------------------------------------------------------
    val subscriptions = FileIO.readSubscriptions()

    val allPosts: List[(String, List[String])] = subscriptions.map { url =>
      println(s"Descargando posts de: $url")
      val json   = FileIO.downloadFeed(url)
      val titles = FileIO.extractPostTitles(json)
      (url, titles)
    }

    // ------------------------------------------------------------------
    // Paso 3: Detectar entidades y mostrar resultados por post
    // ------------------------------------------------------------------
    // TODO (Ejercicios 3, 4 y 6):
    //   Para cada post:
    //     1. Detectar entidades
    //     2. Formatear y mostrar el resultado

    //esta linea lo que hace es crear una lista de eentidades relacionadas a sus respectivos tipos
    val detected_entitis : List[NamedEntity] = detectEntities(allPosts._2, Dictionary)

    // ------------------------------------------------------------------
    // Paso 4: Estadísticas globales
    // ------------------------------------------------------------------
    // TODO (Ejercicios 5 y 6):
    //   1. Recolectar TODAS las entidades detectadas en todos los posts
    //   2. Contar por tipo
    //   3. Mostrar el resumen

  }
}

package msky.dc.recruitment.auditlogpresenter.hardcodeddata

import java.io.BufferedReader

class CsvContentReader {

    fun getCsvHeaderlessContent(resourcePath: String): BufferedReader {
        val reader = this::class.java.getResourceAsStream(resourcePath)
                .bufferedReader()
        skipHeader(reader)

        return reader
    }

    private fun skipHeader(reader: BufferedReader) {
        reader.readLine()
    }
}
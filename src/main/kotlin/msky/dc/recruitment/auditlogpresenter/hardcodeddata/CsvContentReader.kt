package msky.dc.recruitment.auditlogpresenter.hardcodeddata

import com.opencsv.CSVReader
import com.opencsv.CSVReaderBuilder

class CsvContentReader {

    fun getCsvHeaderlessContentLines(resourcePath: String): List<Array<String>> {
        val reader = buildReaderOmittingHeader(resourcePath)

        return reader.readAll().filter { isNotEmpty(it) }
    }

    private fun isNotEmpty(line: Array<String>): Boolean {
        return line.isNotEmpty() && line.all { it.isNotBlank() }
    }

    private fun buildReaderOmittingHeader(resourcePath: String): CSVReader {
        return CSVReaderBuilder(this::class.java.getResourceAsStream(resourcePath)
                .bufferedReader())
                .withSkipLines(1)
                .build()
    }
}
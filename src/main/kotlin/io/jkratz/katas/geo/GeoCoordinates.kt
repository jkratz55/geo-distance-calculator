package io.jkratz.katas.geo

data class GeoCoordinates(val latitude: Double,
                          val longitude: Double) {

    init {
        if (this.latitude < -90.00 || this.latitude > 90) throw IllegalArgumentException("Invalid latitude value")
        if (this.longitude < -180 || this.longitude > 180) throw IllegalArgumentException("Invalid longitude value")
    }

    fun calculateDistance(destination: GeoCoordinates, units: DistanceUnit = DistanceUnit.Kilometers): Double {

        val dlong = (destination.longitude - this.longitude) * DecimalToRadians
        val dlat = (destination.latitude - this.latitude) * DecimalToRadians
        val a = Math.pow(Math.sin(dlat / 2.0), 2.0) + (Math.cos(this.latitude * DecimalToRadians)
                * Math.cos(destination.latitude * DecimalToRadians)
                * Math.pow(Math.sin(dlong / 2.0), 2.0));
        val c = 2.0 * Math.atan2(Math.sqrt(a), Math.sqrt(1.0 - a))
        val d = EarthRadius * c

        return when (units) {
            DistanceUnit.Kilometers -> d
            DistanceUnit.Miles -> d / KilometersToMiles;
        }
    }

    companion object {
        const val EarthRadius: Double = 6378.1370
        const val DecimalToRadians: Double = Math.PI / 180;
        const val KilometersToMiles: Double = 1.609344
    }
}

enum class DistanceUnit {
    Kilometers,
    Miles
}
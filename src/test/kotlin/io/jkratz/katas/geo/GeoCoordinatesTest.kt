package io.jkratz.katas.geo

import org.junit.Test
import org.junit.Assert.*

class GeoCoordinatesTest {

    @Test
    fun testCalculateDistanceSameLocation() {

        val middleOfNoWhere = GeoCoordinates(0.0,0.0)
        val distance = middleOfNoWhere.calculateDistance(GeoCoordinates(0.0, 0.0))

        assertEquals(0.0, distance, 0.0)
    }

    @Test
    fun testCalculateDistance() {

        val columbusOhio = GeoCoordinates(39.9611755, -82.9987942);
        val clevelandOhio = GeoCoordinates(41.505493, -81.681290);

        assertEquals(127.19, clevelandOhio.calculateDistance(columbusOhio, DistanceUnit.Miles), 0.1);
        assertEquals(204.700, clevelandOhio.calculateDistance(columbusOhio, DistanceUnit.Kilometers), 0.1);

        println(columbusOhio.calculateDistance(clevelandOhio, DistanceUnit.Miles))
        println(columbusOhio.calculateDistance(clevelandOhio, DistanceUnit.Kilometers))
    }

    @Test(expected = IllegalArgumentException::class)
    fun testInvalidGeoCoordinates() {
        val point = GeoCoordinates(94.00, 198.00)
    }
}
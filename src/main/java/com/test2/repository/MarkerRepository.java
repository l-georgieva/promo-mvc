package com.test2.repository;

import com.test2.entities.Marker;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Repository
public interface MarkerRepository extends CrudRepository<Marker, Long> {

    @Query(value = "SELECT m.name,\n" +
            "    m.latitude, m.longitude,\n" +
            "    p.distance_unit\n" +
            "             * DEGREES(ACOS(COS(RADIANS(p.latitude.point))\n" +
            "             * COS(RADIANS(m.latitude))\n" +
            "             * COS(RADIANS(p.longitude.point) - RADIANS(m.longitude))\n" +
            "             + SIN(RADIANS(p.latitude.point))\n" +
            "             * SIN(RADIANS(m.latitude)))) AS distance_in_km\n" +
            "FROM markers AS m\n" +
            "JOIN (\n" +
            "      SELECT latitudes AS latitude.point,longitudes AS longitude.point,\n" +
            "             50.0 AS radius, 111.045 AS distance_unit\n" +
            "     ) AS p ON 1=1\n" +
            "WHERE m.latitude\n" +
            "BETWEEN p.latitude.point  - (p.radius / p.distance_unit)\n" +
            "    AND p.latitude.point  + (p.radius / p.distance_unit)\n" +
            "    AND m.longitude BETWEEN p.longitude.point - (p.radius / (p.distance_unit * COS(RADIANS(p.latitude.point))))\n" +
            "    AND p.longitude.point + (p.radius / (p.distance_unit * COS(RADIANS(p.latitude.point))))\n" +
            "ORDER BY distance_in_km")
    List<String> getMarkerAddresses();
    List<String[]> addresses = new ArrayList<String[]>();
    //Set<Marker> getAllByAddressIn(Collection<String> address);
    Set<Marker> getAllByAddressIn(Collection<String> address);

    List<String> getMarkers();

    //List<String> getMarkerAddresses();
}
//LessThanOrderByLatitudeAndLongitudeAndLatitudeAndLongitude
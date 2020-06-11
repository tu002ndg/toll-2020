package jdev.dto;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by jdev on 06.03.2017.
 */
public class PointDTOTest {

    private String expected = "{\"lat\":56.0,\"lon\":74.0,\"autoId\":\"o567gfd\",\"time\":1591911504689}";
    private String autoId ="o567gfd";
    private double lat=56.0;
    private double lon=74.0;

    @Test
    public void toJson() throws Exception {
        PointDTO point = new PointDTO();
        point.setLat(56);
        point.setLon(74);
        point.setAutoId("o567gfd");
        point.setTime(System.currentTimeMillis());
        assertTrue(point.toJson().contains("\"lat\":56"));
        assertTrue(point.toJson().contains("\"lat\":56"));
        System.out.println(point.toJson());
    }

    @Test
    public void decodeDTO() throws Exception {

        ObjectMapper mapper = new ObjectMapper();
        PointDTO dto = mapper.readValue(expected, PointDTO.class);
        assertEquals(autoId, dto.getAutoId());
        assertEquals(1591911504689L, dto.getTime());
        assertEquals(lat, dto.getLat(),0);
        assertEquals(lon, dto.getLon(),0);

    }

}
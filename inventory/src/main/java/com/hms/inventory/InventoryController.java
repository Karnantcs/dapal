package com.hms.inventory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.hms.inventory.model.Tracks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InventoryController {

	@Autowired JdbcTemplate jdbcTemplate;

	@RequestMapping(value = "/list" , method = RequestMethod.GET)
	public List<Tracks> getLists () {
		List<Tracks> albums = new ArrayList<>();
		String listAlbums = "select a.name as album_name, t.name as track_name, t.url from ALBUMS a INNER JOIN TRACKS t ON a.id = t.album_id order by a.name";
		List<Map<String, Object>> list = jdbcTemplate.queryForList(listAlbums);
		for (Map<String, Object> row : list) {
			albums.add(new Tracks((String)row.get("album_name"),(String)row.get("track_name"),(String)row.get("url")));
		}
		return albums;
	}
}

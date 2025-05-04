package Models;

import java.util.List;

import com.couchbase.client.core.deps.com.fasterxml.jackson.core.type.TypeReference;
import com.couchbase.client.core.deps.com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class GenreListConverter implements AttributeConverter<List<Genre>, String> {
	private static final ObjectMapper mapper = new ObjectMapper();
	
	@Override
	public String convertToDatabaseColumn(List<Genre> genres) {
		try {
			return mapper.writeValueAsString(genres);
		} catch (Exception e) {
			return null;
		}
	}
	
	@Override
	public List<Genre> convertToEntityAttribute(String json) {
		try {
			return mapper.readValue(json, new TypeReference<List<Genre>>() {});
		} catch (Exception e) {
			return null;
		}
	}
}

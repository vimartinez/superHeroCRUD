package ar.com.vic.superherocrud.errorhandler;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SuperHeroResponseObject {
	private final ZonedDateTime serverTime = ZonedDateTime.now();
	private final ZoneId serverTimeZone = ZoneId.systemDefault();
	private String status;
	private String statusMessage;
	private String executionTime;
	private String path;
	private String data;

}

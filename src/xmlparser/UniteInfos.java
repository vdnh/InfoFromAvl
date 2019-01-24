package xmlparser;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author vdnh
 */
@Data
@AllArgsConstructor @NoArgsConstructor
public class UniteInfos {
    private String unite;
    private String odometer;
    private String latitude;
    private String longitude;    
}

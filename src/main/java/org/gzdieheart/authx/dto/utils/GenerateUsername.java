package org.gzdieheart.authx.dto.utils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class GenerateUsername {
    private String username;
    private String algorithm;
    private int hashLength;
    private int counter;
}

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package eu.irian.demo.tictactoe.resource;

import eu.irian.demo.tictactoe.model.Field;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.List;

@Path("/ai")
@Produces({"application/json"})
public class FieldResource {

  private static final Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

  @POST
  @Consumes("application/json")
  public Response postField(
      @Parameter(description = "Give current field", required = true) Field field) {
    return Response.ok().entity("SUCCESS").build();
  }

  @PUT
  public Response putField(
      @Parameter(description = "Give current field", required = true) Field field) {
    return Response.ok().entity("SUCCESS").build();
  }

  /**
   * To get an result go to http://localhost:8002/tictactoe/ai/nextMove?field=x o x oox
   */
  @GET
  @Path("/nextMove")
  public int getNextMove(
      @Parameter(
          description = "Give current field, get next move",
          required = true,
          // todo validation by annotations is not working yet
          schema = @Schema(pattern = "[xo ]{9}")
      )
      @QueryParam("field") String fieldString) {


    LOG.info("field is '{}'", fieldString);

    char[] field = fieldString.toCharArray();
    List<Integer> freeFields = new ArrayList<>();
    for (int i = 0; i < field.length; i++) {
      if (' ' == field[i]) {
        freeFields.add(i);
      }
    }
    if (freeFields.size() == 0) {
      return -1;
    } else {
      return freeFields.get((int) (Math.random() * freeFields.size()));
    }
  }
}

package com.socrata.pluginstarter;

import com.socrata.sia.*;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Collectors;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.io.IOException;
import java.util.stream.Stream;
import java.nio.file.Files;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.net.InetAddress;


public class PluginStarter implements Plugin {
  private Config config;

  PluginStarter(Config config) {
    this.config = config;
  }


  @Override
  public Result<DataSourceListResponse> list(List<String> path) {
    // List<DataSourceNode> nodes = Arrays.asList(new File(config.getRoot()).listFiles())
    //         .stream()
    //         .filter(f -> f.isFile() && f.getName().endsWith(".log"))
    //         .map(f -> new DataSourceNode(false, f.getAbsolutePath()))
    //         .collect(Collectors.toList());

    // throw new RuntimeException("oops!");
    // return ResultUtils.ok(new DataSourceListResponse(nodes));
  }

  @Override
  public Result<RowStreamResponse> give(List<String> path, DataSinkProvider dataSinkProvider) {
    // Path target = path
    //         .stream()
    //         .reduce(
    //                 new File("/"),
    //                 (acc, level) -> new File(acc, level),
    //                 (acc, _whyJava) -> acc
    //         ).toPath();

    // if (!target.startsWith(this.config.getRoot())) {
    //   return ResultUtils.error(ts("Path was outside the root"));
    // }

    // ColumnSpec[] schema = new ColumnSpec[]{
    //         new ColumnSpec(SoQLType.TEXT, "date"),
    //         new ColumnSpec(SoQLType.TEXT, "host"),
    //         new ColumnSpec(SoQLType.TEXT, "message")
    // };

    // try (Stream<String> stream = Files.lines(target)) {

    //   RowStream sink = dataSinkProvider.getRowStream(schema);
    //   String hostname = getComputerName();

    //   for (String line : (Iterable<String>)stream::iterator) {
    //     String[] contents = line.split(hostname);
    //     String[] row = new String[] {
    //             contents[0],
    //             hostname,
    //             contents[1]
    //     };
    //     sink.writeRow(row);
    //   }

    //   return ResultUtils.ok(new RowStreamResponse());
    // } catch(IOException ioe) {
    //   ioe.printStackTrace();
    //   return ResultUtils.error(ts("Failed to open the target file"));
    // }
  }

  private String getComputerName() throws UnknownHostException {
    return InetAddress.getLocalHost().getHostName();
  }
  private TranslatedString ts(String s) {
    return new TranslatedString(s, new HashMap<String, String>());
  }

  @Override
  public void teardown() {

  }
}

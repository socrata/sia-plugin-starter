package com.socrata.pluginstarter;

import com.socrata.sia.*;

import java.util.List;


public class PluginStarter implements Plugin {
  private Config config;

  PluginStarter(Config config) {
    this.config = config;
  }


  @Override
  public Result<DataSourceListResponse> list(List<String> list) {

  }

  @Override
  public Result<RowStreamResponse> give(List<String> list, DataSinkProvider dataSinkProvider) {
    
  }

  @Override
  public void teardown() {

  }
}

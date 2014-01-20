package com.lostbeatlive;
import java.util.ArrayList;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.lostbeatlive.adapter.NavDrawerListAdapter;
import com.lostbeatlive.model.NavDrawerItem;

public class MenuFragment extends Fragment {
	
	private ListView list;
	private View rootView;
	private String[] navMenuTitles;
	private TypedArray navMenuIcons;
	
	private ArrayList<NavDrawerItem> navDrawerItems;
	private NavDrawerListAdapter adapter;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		rootView =inflater.inflate(R.layout.fragment_leftmenu, container, false);
		// load slide menu items
		navMenuTitles = getResources().getStringArray(R.array.nav_drawer_items);

		// nav drawer icons from resources
		navMenuIcons = getResources()
				.obtainTypedArray(R.array.nav_drawer_icons);
		
		navDrawerItems = new ArrayList<NavDrawerItem>();
		list = (ListView) rootView.findViewById(R.id.list_leftmenu); 
		
		// adding nav drawer items to array
		// Home
		navDrawerItems.add(new NavDrawerItem(navMenuTitles[0], navMenuIcons.getResourceId(0, -1)));
		// Find People
		navDrawerItems.add(new NavDrawerItem(navMenuTitles[1], navMenuIcons.getResourceId(1, -1)));
		// Photos
		navDrawerItems.add(new NavDrawerItem(navMenuTitles[2], navMenuIcons.getResourceId(2, -1)));
		// Communities, Will add a counter here
		navDrawerItems.add(new NavDrawerItem(navMenuTitles[3], navMenuIcons.getResourceId(3, -1)));
		// Pages
		navDrawerItems.add(new NavDrawerItem(navMenuTitles[4], navMenuIcons.getResourceId(4, -1)));
		// What's hot, We  will add a counter here
		navDrawerItems.add(new NavDrawerItem(navMenuTitles[5], navMenuIcons.getResourceId(5, -1)));
		

		// Recycle the typed array
		navMenuIcons.recycle();
		
		// setting the nav drawer list adapter
		adapter = new NavDrawerListAdapter(getActivity(), navDrawerItems);
		list.setAdapter(adapter);
		list.setOnItemClickListener(new OnItemClickListener(){
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,long id){
				Fragment fragment = null;
				switch (position) {
				case 0:
					fragment = new HomeFragment();
					break;
				case 1:
					fragment = new ProfileFragment();
					break;
				case 2:
					fragment = new BeatBoxFragment();
					break;
				case 3:
					fragment = new NewsfeedFragment();
					break;
				case 4:
					fragment = new TracksFragment();
					break;
				case 5:
					fragment = new HelpFragment();
					break;

				default:
					break;
				}
				
				if (fragment != null){
					MainActivity main = (MainActivity) getActivity();
					main.switchContent(fragment);
					main.setTitle(navMenuTitles[position]);
				}
			}
			
		});		
								
						
		return rootView;
	}
	
}
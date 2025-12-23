import { ThemeProvider } from '@/components/layout/theme-provider';
import { AppSidebar } from '@/components/layout/app-sidebar';
import { SidebarProvider, SidebarInset } from '@/components/ui/sidebar';
export const App = () => {
  return (
    <ThemeProvider
      defaultTheme='dark'
      storageKey='vite-ui-theme'
    >
      <SidebarProvider open={false}>
        <AppSidebar />
        <SidebarInset></SidebarInset>
      </SidebarProvider>
    </ThemeProvider>
  );
};
